package io.acari.doki.laf

import io.acari.doki.ui.TitlePaneUI
import io.acari.doki.ui.tree.BorderTreeIndicator
import io.acari.doki.ui.tree.TreeIndicator
import javax.swing.UIManager


object LookAndFeelInstaller {

  fun installAllUIComponents() {
    installTitlePane()
    installTreeIndicatorComponent()
  }

  fun installTitlePane() {
    val defaults = UIManager.getLookAndFeelDefaults()
    defaults["RootPaneUI"] = TitlePaneUI::class.java.name
    defaults[TitlePaneUI::class.java.name] = TitlePaneUI::class.java
  }

  fun installTreeIndicatorComponent() {
    val uiDefaults = UIManager.getLookAndFeelDefaults()
    val indicatorPainter = BorderTreeIndicator()
    val treeIndicator = TreeIndicator(indicatorPainter)
    uiDefaults["List.sourceListSelectionBackgroundPainter"] = treeIndicator
    uiDefaults["List.sourceListFocusedSelectionBackgroundPainter"] = treeIndicator
  }
}