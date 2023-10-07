package com.readcsb.frontend;


import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.router.Route;
import io.undertow.server.handlers.form.FormData;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

@Route("")
public class CSVUpload extends VerticalLayout {


    private Grid<String[]> grid = new Grid<>();

        public CSVUpload() {

            MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
            Upload upload = new Upload(buffer);

            upload.addSucceededListener(event -> {
                String fileName = event.getFileName();
                InputStream inputStream = buffer.getInputStream(fileName);
                CSVUpload csvUpload= new CSVUpload();

            });



            add(upload);
    }

}
