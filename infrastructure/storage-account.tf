provider "azurerm" {
  alias                      = "mgmt"
  subscription_id            = var.mgmt_subscription_id
  skip_provider_registration = true
  features {}
}

locals {
  container_names = [
    "pdf",
    "xml",
    "test"
  ]

  ip_rules = [
    "81.134.202.29",
    "137.220.122.126",
    "31.14.249.216",
  ]

  jenkins_subnet_ids = [for k, v in data.azurerm_subnet.jenkins_subnets : data.azurerm_subnet.jenkins_subnets[k].id]
  env_subnet_ids = [for k, v in data.azurerm_subnet.environment_subnets : data.azurerm_subnet.environment_subnets[k].id]

  tags    = var.common_tags
}

module "storage_account" {
  source                     = "git@github.com:hmcts/cnp-module-storage-account?ref=master"
  env                        = var.env
  storage_account_name       = replace("${var.product}${var.component}${var.env}", "-", "")
  resource_group_name        = azurerm_resource_group.rg.name
  location                   = azurerm_resource_group.rg.location
  account_kind               = "BlobStorage"
  account_tier               = "Standard"
  account_replication_type   = var.storage_account_repl_type
  sa_subnets                 = concat(local.jenkins_subnet_ids, local.env_subnet_ids)
  managed_identity_object_id = data.azurerm_user_assigned_identity.lgy_iac_mi.principal_id
  role_assignments = [
      "Storage Blob Delegator",
      "Storage Blob Data Contributor",
      "Storage Blob Data Reader"
  ]

  common_tags = local.tags
}

resource "azurerm_storage_container" "service_containers" {
  for_each             = toset(local.container_names)
  name                 = each.value
  storage_account_name = module.storage_account.storageaccount_name
}

resource "azurerm_key_vault_secret" "storage_account_name" {
  name         = "storage-account-name"
  value        = module.storage_account.storageaccount_name
  key_vault_id = module.vault.key_vault_id
}

resource "azurerm_key_vault_secret" "storage_account_primary_key" {
  name         = "storage-account-primary-key"
  value        = module.storage_account.storageaccount_primary_access_key
  key_vault_id = module.vault.key_vault_id
}

# this secret is used by blob-router-service for uploading blobs
resource "azurerm_key_vault_secret" "storage_account_connection_string" {
  name         = "storage-account-connection-string"
  value        = module.storage_account.storageaccount_primary_connection_string
  key_vault_id = module.vault.key_vault_id
}

output "storage_account_name" {
  value = module.storage_account.storageaccount_name
}

output "storage_account_primary_key" {
  sensitive = true
  value     = module.storage_account.storageaccount_primary_access_key
}
