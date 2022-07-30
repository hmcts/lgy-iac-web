module "database" {
  source             = "git@github.com:hmcts/cnp-module-postgres?ref=master"
  product            = "hmcts-${var.product}"
  location           = var.location
  env                = var.env
  postgresql_user    = "lgy-iac-admin"
  database_name      = "lgy-iac"
  postgresql_version = "11"
  sku_name           = "GP_Gen5_4"
  sku_tier           = "GeneralPurpose"
  storage_mb         = "179200"
  common_tags        = var.common_tags
  subscription       = var.subscription
  sku_capacity       = 4
  key_vault_rg       = "genesis-rg"
  key_vault_name     = "dtssharedservices${var.env}kv"
}

resource "azurerm_key_vault_secret" "postgres-user" {
  name         = "lgy-iac-POSTGRES-USER"
  value        = module.database.user_name
  key_vault_id = module.vault.key_vault_id
}

resource "azurerm_key_vault_secret" "postgres-password" {
  name         = "lgy-iac-POSTGRES-PASS"
  value        = module.database.postgresql_password
  key_vault_id = module.vault.key_vault_id
}

resource "azurerm_key_vault_secret" "postgres-host" {
  name         = "lgy-iac-POSTGRES-HOST"
  value        = module.database.host_name
  key_vault_id = module.vault.key_vault_id
}

resource "azurerm_key_vault_secret" "postgres-port" {
  name         = "lgy-iac-POSTGRES-PORT"
  value        = module.database.postgresql_listen_port
  key_vault_id = module.vault.key_vault_id
}

resource "azurerm_key_vault_secret" "postgres-database" {
  name         = "lgy-iac-POSTGRES-DATABASE"
  value        = module.database.postgresql_database
  key_vault_id = module.vault.key_vault_id
}
