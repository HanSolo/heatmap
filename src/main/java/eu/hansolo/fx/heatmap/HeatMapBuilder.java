/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2016-2021 Gerrit Grunwald.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.hansolo.fx.heatmap;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Dimension2D;

import java.util.HashMap;


public class HeatMapBuilder<B extends HeatMapBuilder<B>> {
    private final HashMap<String, Property> properties = new HashMap<>();


    // ******************** Constructors **************************************
    protected HeatMapBuilder() { }


    // ******************** Methods *******************************************
    public final static HeatMapBuilder create() {
        return new HeatMapBuilder();
    }

    public final B prefSize(final double width, final double height) {
        return prefSize(new Dimension2D(width, height));
    }

    public final B prefSize(final Dimension2D prefSize) {
        properties.put("prefSize", new SimpleObjectProperty<>(prefSize));
        return (B)this;
    }

    public final B width(final double width) {
        properties.put("width", new SimpleDoubleProperty(width));
        return (B)this;
    }

    public final B height(final double height) {
        properties.put("height", new SimpleDoubleProperty(height));
        return (B)this;
    }

    public final B colorMapping(final Mapping colorMapping) {
        properties.put("colorMapping", new SimpleObjectProperty<>(colorMapping));
        return (B)this;
    }

    public final B spotRadius(final double spotRadius) {
        properties.put("spotRadius", new SimpleDoubleProperty(spotRadius));
        return (B)this;
    }

    public final B fadeColors(final boolean fadeColors) {
        properties.put("fadeColors", new SimpleBooleanProperty(fadeColors));
        return (B)this;
    }

    public final B heatMapOpacity(final double heatMapOpacity) {
        properties.put("heatMapOpacity", new SimpleDoubleProperty(heatMapOpacity));
        return (B)this;
    }

    public final B opacityDistribution(final OpacityDistribution opacityDistribution) {
        properties.put("opacityDistribution", new SimpleObjectProperty<>(opacityDistribution));
        return (B)this;
    }


    public final HeatMap build() {
        double              width               = 400;
        double              height              = 400;
        Mapping             colorMapping        = ColorMapping.LIME_YELLOW_RED;
        double              spotRadius          = 15.5;
        boolean             fadeColors          = false;
        double              heatMapOpacity      = 0.5;
        OpacityDistribution opacityDistribution = OpacityDistribution.CUSTOM;

        for (String key : properties.keySet()) {
            switch(key) {
                case "prefSize"            -> {
                    Dimension2D dim = ((ObjectProperty<Dimension2D>) properties.get(key)).get();
                    width  = dim.getWidth();
                    height = dim.getHeight();
                }
                case "width"               -> width               = ((DoubleProperty) properties.get(key)).get();
                case "height"              -> height              = ((DoubleProperty) properties.get(key)).get();
                case "colorMapping"        -> colorMapping        = ((ObjectProperty<Mapping>) properties.get(key)).get();
                case "spotRadius"          -> spotRadius          = ((DoubleProperty) properties.get(key)).get();
                case "fadeColors"          -> fadeColors          = ((BooleanProperty) properties.get(key)).get();
                case "heatMapOpacity"      -> heatMapOpacity      = ((DoubleProperty) properties.get(key)).get();
                case "opacityDistribution" -> opacityDistribution = ((ObjectProperty<OpacityDistribution>) properties.get(key)).get();
            }
        }
        return new HeatMap(width,  height, colorMapping, spotRadius, fadeColors, heatMapOpacity, opacityDistribution);
    }
}
