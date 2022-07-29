module "vault" {
  source                     = "git@github.com:hmcts/cnp-module-key-vault?ref=master"
  name                       = local.vault_name
  product                    = var.product
  env                        = var.env
  tenant_id                  = var.tenant_id
  object_id                  = var.jenkins_AAD_objectId
  resource_group_name        = azurerm_resource_group.rg.name
  product_group_name         = "DTS SDS Developers"
  create_managed_identity    = true
  common_tags                = var.common_tags
  network_acls_allowed_subnet_ids = [data.azurerm_subnet.jenkins_subnet.id]
  network_acls_allowed_ip_ranges = ["IPs"]
  network_acls_default_action = "Deny" # Allow by default
}

# Set by the Jenkins pipeline
variable "mgmt_subscription_id" {}

provider "azurerm" {
  alias           = "mgmt"
  subscription_id = var.mgmt_subscription_id
  features {}
}

# for SDS
data "azurerm_subnet" "jenkins_subnet" {
  provider             = azurerm.mgmt
  name                 = "iaas"
  virtual_network_name = var.env == "sbox" ? "ss-ptlsbox-vnet" : "ss-ptl-vnet"
  resource_group_name  = var.env == "sbox" ? "ss-ptlsbox-network-rg" : "ss-ptl-network-rg"
}
