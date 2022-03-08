module eu.hansolo.fx.heatmap {
    // Java
    requires java.base;

    // Java-FX
    requires transitive javafx.base;
    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires transitive javafx.swing;

    // 3rd Party
    requires transitive eu.hansolo.toolbox;
    requires transitive eu.hansolo.toolboxfx;

    opens eu.hansolo.fx.heatmap to eu.hansolo.toolbox, eu.hansolo.toolboxfx;

    exports eu.hansolo.fx.heatmap;
}