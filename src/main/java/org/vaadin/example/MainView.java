package org.vaadin.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.Route;


@Route
@CssImport(value = "./styles/vaadin-upload-styles.css", themeFor = "vaadin-upload-file")
public class MainView extends VerticalLayout {

    public MainView() {

        MemoryBuffer buffer = new MemoryBuffer();
        Upload upload = new Upload(buffer);
        upload.addSucceededListener(e -> {
            upload.getElement()
                    .executeJs("this.shadowRoot.querySelector('vaadin-upload-file').className = 'hidden-clear'");
        });

        Button showClear = new Button("Show clear button", e -> upload.getElement()
                .executeJs("this.shadowRoot.querySelector('vaadin-upload-file').className = ''"));

        add(upload, showClear);
    }

}
