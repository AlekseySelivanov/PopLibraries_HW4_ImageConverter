package com.example.imageconverter.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView: MvpView {
    fun startConvertion()
    fun showDialogue()
    fun hideDialogue()

    fun showResult()
    fun showError()
    fun showInterrupted()
}