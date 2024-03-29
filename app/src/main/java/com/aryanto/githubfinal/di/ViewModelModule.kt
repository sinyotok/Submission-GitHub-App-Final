package com.aryanto.githubfinal.di

import com.aryanto.githubfinal.ui.activity.detail.DetailVM
import com.aryanto.githubfinal.ui.activity.favorite.FavoriteVM
import com.aryanto.githubfinal.ui.activity.home.HomeVM
import com.aryanto.githubfinal.ui.fragment.followers.FollowersVM
import com.aryanto.githubfinal.ui.fragment.following.FollowingVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeVM(get(), get()) }
    viewModel { DetailVM(get(), get()) }
    viewModel { FollowersVM(get()) }
    viewModel { FollowingVM(get()) }
    viewModel { FavoriteVM(get()) }
}