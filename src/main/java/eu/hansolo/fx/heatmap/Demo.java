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

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Demo extends Application {
    private HeatMap heatMap;

    @Override public void init() {
        heatMap = new HeatMap(400, 400, ColorMapping.BLUE_RED_YELLOW, 15.5, true, 0.5, OpacityDistribution.EXPONENTIAL);
    }

    @Override public void start(final Stage stage) {
        StackPane pane = new StackPane(heatMap, new Label("Click to add spot"));
        heatMap.addSpot(100, 100);
        heatMap.addSpot(105, 105);
        heatMap.addSpot(200, 200);
        heatMap.addSpot(200, 200);

        Scene scene = new Scene(pane, 400, 400);
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> heatMap.addSpot(e.getSceneX(), e.getSceneY()));

        stage.setTitle("HeatMap");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    @Override public void stop() {

    }

    public static void main(String[] args) {
        launch(args);
    }
}
