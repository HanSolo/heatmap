module eu.hansolo.fx.heatmap {
    // Java
    requires java.base;

    // Java-FX
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.swing;

    // 3rd Party
    requires transitive eu.hansolo.toolboxfx;

    opens eu.hansolo.fx.heatmap to eu.hansolo.toolboxfx;

    exports eu.hansolo.fx.heatmap;
}
