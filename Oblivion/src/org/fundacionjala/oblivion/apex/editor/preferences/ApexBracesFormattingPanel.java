/*
 * Copyright (c) Fundacion Jala. All rights reserved.
 * Licensed under the MIT license. See LICENSE file in the project root for full license information.
 */ 
package org.fundacionjala.oblivion.apex.editor.preferences;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;

import static org.fundacionjala.oblivion.apex.editor.preferences.BracesValueOptions.*;
import org.netbeans.modules.options.editor.spi.PreferencesCustomizer;
import org.openide.util.NbBundle;

/**
 * This panel is shown in the Apex editor options.
 *
 * @author Amir Aranibar
 */
public class ApexBracesFormattingPanel extends ApexFormattingPanel {

    private final String[] comboBoxValues;

    /**
     * Creates new form FormatBraces
     */
    public ApexBracesFormattingPanel() {
        comboBoxValues = new String[]{SAME_LINE, NEW_LINE};
        initComponents();
    }

    @Override
    void load(Preferences preferences) {
        FormatOptions formatOptions = FormatOptions.getInstance();

        classDeclarationCombo.setSelectedItem(formatOptions.getOptionValue(preferences, PreferencesFormatOptions.BRACES_IN_CLASS_DECLARATION.name()));
        methodDeclarationCombo.setSelectedItem(formatOptions.getOptionValue(preferences, PreferencesFormatOptions.BRACES_IN_METHOD_DECLARATION.name()));
        otherDeclarationCombo.setSelectedItem(formatOptions.getOptionValue(preferences, PreferencesFormatOptions.BRACES_IN_OTHER_DECLARATION.name()));
    }

    @Override
    void store(Preferences preferences) {
        FormatOptions formatOptions = FormatOptions.getInstance();

        formatOptions.setOptionValue(preferences, PreferencesFormatOptions.BRACES_IN_CLASS_DECLARATION.name(), classDeclarationCombo.getSelectedItem().toString());
        formatOptions.setOptionValue(preferences, PreferencesFormatOptions.BRACES_IN_METHOD_DECLARATION.name(), methodDeclarationCombo.getSelectedItem().toString());
        formatOptions.setOptionValue(preferences, PreferencesFormatOptions.BRACES_IN_OTHER_DECLARATION.name(), otherDeclarationCombo.getSelectedItem().toString());
    }

    @Override
    List<JComponent> getComponentsToListen() {
        List<JComponent> components = new ArrayList<>();
        components.add(classDeclarationCombo);
        components.add(methodDeclarationCombo);
        components.add(otherDeclarationCombo);

        return components;
    }

    @Override
    String getPreviewText(Preferences preferences) {
        FormatOptions formatOptions = FormatOptions.getInstance();

        StringBuilder previewTextLabel = new StringBuilder("SAMPLE_Braces");
        String classDeclarationOption = formatOptions.getOptionValue(preferences, PreferencesFormatOptions.BRACES_IN_CLASS_DECLARATION.name());
        String methodDeclarationOption = formatOptions.getOptionValue(preferences, PreferencesFormatOptions.BRACES_IN_METHOD_DECLARATION.name());
        String otherDeclarationOption = formatOptions.getOptionValue(preferences, PreferencesFormatOptions.BRACES_IN_OTHER_DECLARATION.name());

        if (classDeclarationOption.equals(SAME_LINE)) {
            previewTextLabel.append("_CS");
        } else {
            previewTextLabel.append("_CN");
        }

        if (methodDeclarationOption.equals(SAME_LINE)) {
            previewTextLabel.append("_MS");
        } else {
            previewTextLabel.append("_MN");
        }

        if (otherDeclarationOption.equals(SAME_LINE)) {
            previewTextLabel.append("_OS");
        } else {
            previewTextLabel.append("_ON");
        }

        return NbBundle.getMessage(ApexBracesFormattingPanel.class, previewTextLabel.toString());
    }

    public static PreferencesCustomizer.Factory getController() {
        return new FormattingPanelController.Factory("braces", ApexBracesFormattingPanel.class,
                NbBundle.getMessage(ApexBracesFormattingPanel.class, "SAMPLE_Default"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        classDeclarationCombo = new javax.swing.JComboBox();
        classDeclarationLabel = new javax.swing.JLabel();
        methodDeclarationLabel = new javax.swing.JLabel();
        methodDeclarationCombo = new javax.swing.JComboBox();
        otherDeclarationLabel = new javax.swing.JLabel();
        otherDeclarationCombo = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        bracesPlacementLabel = new javax.swing.JLabel();

        setName(org.openide.util.NbBundle.getMessage(ApexBracesFormattingPanel.class, "LBL_Braces")); // NOI18N

        classDeclarationCombo.setModel(new DefaultComboBoxModel(comboBoxValues));

        org.openide.awt.Mnemonics.setLocalizedText(classDeclarationLabel, org.openide.util.NbBundle.getMessage(ApexBracesFormattingPanel.class, "ApexBracesFormattingPanel.classDeclarationLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(methodDeclarationLabel, org.openide.util.NbBundle.getMessage(ApexBracesFormattingPanel.class, "ApexBracesFormattingPanel.methodDeclarationLabel.text")); // NOI18N

        methodDeclarationCombo.setModel(new DefaultComboBoxModel(comboBoxValues));

        org.openide.awt.Mnemonics.setLocalizedText(otherDeclarationLabel, org.openide.util.NbBundle.getMessage(ApexBracesFormattingPanel.class, "ApexBracesFormattingPanel.otherDeclarationLabel.text")); // NOI18N

        otherDeclarationCombo.setModel(new DefaultComboBoxModel(comboBoxValues));

        org.openide.awt.Mnemonics.setLocalizedText(bracesPlacementLabel, org.openide.util.NbBundle.getMessage(ApexBracesFormattingPanel.class, "ApexBracesFormattingPanel.bracesPlacementLabel.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(methodDeclarationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(classDeclarationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(classDeclarationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(methodDeclarationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(otherDeclarationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(otherDeclarationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bracesPlacementLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bracesPlacementLabel)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classDeclarationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classDeclarationLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(methodDeclarationLabel)
                    .addComponent(methodDeclarationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(otherDeclarationLabel)
                    .addComponent(otherDeclarationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(93, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bracesPlacementLabel;
    private javax.swing.JComboBox classDeclarationCombo;
    private javax.swing.JLabel classDeclarationLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox methodDeclarationCombo;
    private javax.swing.JLabel methodDeclarationLabel;
    private javax.swing.JComboBox otherDeclarationCombo;
    private javax.swing.JLabel otherDeclarationLabel;
    // End of variables declaration//GEN-END:variables
}
