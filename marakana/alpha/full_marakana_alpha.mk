# Inherit from the emulator product, which defines the base OS
#$(call inherit-product, $(SRC_TARGET_DIR)/product/full.mk)

# Inherit from the common Open Source product configuration
$(call inherit-product, $(SRC_TARGET_DIR)/product/full_base_telephony.mk)

# Inherit from hardware-specific part of the product configuration
$(call inherit-product, $(LOCAL_PATH)/device.mk)

# Discard inherited values and use our own instead
PRODUCT_NAME := full_marakana_alpha
PRODUCT_DEVICE := alpha
PRODUCT_MODEL := Full Marakana Alpha Image for Emulator
PRODUCT_LOCALES := ru_RU en_US

# Include the common definitions and packages
include $(LOCAL_PATH)/common.mk
