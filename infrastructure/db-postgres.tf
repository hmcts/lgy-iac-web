data "azurerm_subnet" "postgres" {
  name                 = "iaas"
  resource_group_name  = "ss-${var.env}-network-rg"
  virtual_network_name = "ss-${var.env}-vnet"
}

resource "azurerm_key_vault_secret" "web-postgres-user" {
  name         = "web-POSTGRES-USER"
  value        = module.database.user_name
  key_vault_id = module.vault.key_vault_id
}

resource "azurerm_key_vault_secret" "web-postgres-password" {
  name         = "web-POSTGRES-PASS"
  value        = module.database.postgresql_password
  key_vault_id = module.vault.key_vault_id
}

resource "azurerm_key_vault_secret" "web-postgres-host" {
  name         = "web-POSTGRES-HOST"
  value        = module.database.host_name
  key_vault_id = module.vault.key_vault_id
}

resource "azurerm_key_vault_secret" "web-postgres-port" {
  name         = "web-POSTGRES-PORT"
  value        = module.database.postgresql_listen_port
  key_vault_id = module.vault.key_vault_id
}

resource "azurerm_key_vault_secret" "web-postgres-database" {
  name         = "web-POSTGRES-DATABASE"
  value        = module.database.postgresql_database
  key_vault_id = module.vault.key_vault_id
}

module "database" {
  source             = "git@github.com:hmcts/cnp-module-postgres?ref=postgresql_tf"
  product            = "hmcts-${var.product}"
  name               = "${var.product}-v11"
  location           = var.location
  env                = var.env
  postgresql_user    = "lgyiacadmin"
  database_name      = "lgyiac"
  postgresql_version = "11"
  subnet_id          = data.azurerm_subnet.postgres.id
  sku_name           = "GP_Gen5_4"
  sku_tier           = "GeneralPurpose"
  storage_mb         = "179200"
  common_tags        = var.common_tags
  subscription       = var.subscription
  sku_capacity       = 4
  key_vault_rg       = "genesis-rg"
  key_vault_name     = "dtssharedservices${var.env}kv"
  business_area      = "SDS"
}
