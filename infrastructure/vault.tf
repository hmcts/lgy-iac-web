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
}
