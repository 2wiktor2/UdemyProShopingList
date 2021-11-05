package com.wiktor.udemyproshopinglist.presentation

import androidx.lifecycle.ViewModel
import com.wiktor.udemyproshopinglist.data.ShopListRepositoryImpl
import com.wiktor.udemyproshopinglist.domain.DeleteShopItemUseCase
import com.wiktor.udemyproshopinglist.domain.EditShooItemUseCase
import com.wiktor.udemyproshopinglist.domain.GetShopListUseCase
import com.wiktor.udemyproshopinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopListUseCase = EditShooItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()


    fun deleteShopList(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }


    fun changeEnabledState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopListUseCase.editShopItem(newItem)
    }
}