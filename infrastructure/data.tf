# The Storage Account needs access to various Azure Virtual Networks in the SDS Subscription
# These are in the ss-ptl-vnet and the ss-<env>-vnet
# Define the azurerm resources here so they can be referenced in the sa_subnets array in storage-account.tf

# *** Maybe need to add perftest (ss-test-vnet) ***



locals {
  subnet_names = [
    "aks-00",
    "aks-01",
    "iaas"
  ]
}

data "azurerm_subnet" "jenkins_subnets" {
  for_each             = toset(local.subnet_names)
  provider             = azurerm.mgmt
  name                 = each.value
  virtual_network_name = "ss-ptl-vnet"
  resource_group_name  = "ss-ptl-network-rg"
}

data "azurerm_subnet" "environment_subnets" {
  for_each             = toset(local.subnet_names)
  provider             = azurerm.aks
  name                 = each.value
  virtual_network_name = "ss-${var.env}-vnet"
  resource_group_name  = "ss-${var.env}-network-rg"
}

# The dts-legacy.lgy-iac Managed Identity from Azure
data "azurerm_user_assigned_identity" "lgy_iac_mi" {
  name                = "lgy-iac-${var.env}-mi"
  resource_group_name = "managed-identities-${var.env}-rg"
}
