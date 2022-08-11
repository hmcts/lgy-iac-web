# sds-prod = 5ca62022-6aa2-4cee-aaa7-e7536c8d566c
# sds-stg = 74dacd4f-a248-45bb-a2f0-af700dc4cf68
# sds-dev = 867a878b-cb68-4de5-9741-361ac9e178b6

provider "azurerm" {
  features {}
  alias                      = "aks"
  subscription_id            = "74dacd4f-a248-45bb-a2f0-af700dc4cf68"
  skip_provider_registration = true
}
