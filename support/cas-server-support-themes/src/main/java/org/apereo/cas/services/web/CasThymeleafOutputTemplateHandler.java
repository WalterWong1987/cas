package org.apereo.cas.services.web;

import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.engine.AbstractTemplateHandler;
import org.thymeleaf.model.ICloseElementTag;
import org.thymeleaf.model.IOpenElementTag;
import org.thymeleaf.model.IText;
import lombok.NoArgsConstructor;

/**
 * This is {@link CasThymeleafOutputTemplateHandler}.
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@Slf4j
@NoArgsConstructor
public class CasThymeleafOutputTemplateHandler extends AbstractTemplateHandler {

    private boolean writeWhitespace;

    @Override
    public void handleText(final IText text) {
        final String contentString = text.getText();
        if (!contentString.isEmpty()) {
            if (!writeWhitespace) {
                return;
            }
            writeWhitespace = false;
        }
        super.handleText(text);
    }

    @Override
    public void handleCloseElement(final ICloseElementTag tag) {
        super.handleCloseElement(tag);
        writeWhitespace = true;
    }

    @Override
    public void handleOpenElement(final IOpenElementTag openElementTag) {
        super.handleOpenElement(openElementTag);
        writeWhitespace = true;
    }
}
