/*
 * Copyright 2025 ExperimentalIdea
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * */
package com.experimentalidea.replaypacketcleaner.gui;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReplayFileDropTarget extends DropTarget {

    public ReplayFileDropTarget(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    private final MainWindow mainWindow;


    @Override
    public synchronized void drop(DropTargetDropEvent event) {
        try {
            Transferable transferable = event.getTransferable();
            DataFlavor[] dataFlavors = transferable.getTransferDataFlavors();
            for (DataFlavor flavor : dataFlavors) {
                if (flavor.isFlavorJavaFileListType()) {
                    event.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                    List<File> files = (List<File>) transferable.getTransferData(flavor);

                    this.mainWindow.AttemptImportOfReplayArchives(files.toArray(new File[0]));

                    event.dropComplete(true);
                    return;
                }
            }

            event.rejectDrop();

        } catch (UnsupportedFlavorException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}


