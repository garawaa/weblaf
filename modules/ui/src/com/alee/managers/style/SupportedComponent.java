/*
 * This file is part of WebLookAndFeel library.
 *
 * WebLookAndFeel library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * WebLookAndFeel library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with WebLookAndFeel library.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.alee.managers.style;

import com.alee.extended.button.WebSplitButton;
import com.alee.extended.checkbox.WebTristateCheckBox;
import com.alee.extended.label.WebStyledLabel;
import com.alee.laf.StyleId;
import com.alee.laf.WebLookAndFeel;
import com.alee.managers.log.Log;
import com.alee.utils.ReflectUtils;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.table.JTableHeader;
import java.util.*;

/**
 * This enumeration represents list of Swing and WebLaF components which support WebLaF styling.
 * It also contains some references and useful settings for each component type.
 *
 * @author Mikle Garin
 * @see <a href="https://github.com/mgarin/weblaf/wiki/How-to-use-StyleManager">How to use StyleManager</a>
 * @see com.alee.managers.style.StyleManager
 * @see com.alee.laf.WebLookAndFeel
 */

public enum SupportedComponent
{
    /**
     * Label-related components.
     */
    label ( true, JLabel.class, "LabelUI", WebLookAndFeel.labelUI ),
    styledLabel ( true, WebStyledLabel.class, "StyledLabelUI", WebLookAndFeel.styledLabelUI ),
    toolTip ( true, JToolTip.class, "ToolTipUI", WebLookAndFeel.toolTipUI ),

    /**
     * Button-related components.
     */
    button ( true, JButton.class, "ButtonUI", WebLookAndFeel.buttonUI ),
    splitButton ( true, WebSplitButton.class, "SplitButtonUI", WebLookAndFeel.splitButtonUI ),
    toggleButton ( true, JToggleButton.class, "ToggleButtonUI", WebLookAndFeel.toggleButtonUI ),
    checkBox ( true, JCheckBox.class, "CheckBoxUI", WebLookAndFeel.checkBoxUI ),
    tristateCheckBox ( true, WebTristateCheckBox.class, "TristateCheckBoxUI", WebLookAndFeel.tristateCheckBoxUI ),
    radioButton ( true, JRadioButton.class, "RadioButtonUI", WebLookAndFeel.radioButtonUI ),

    /**
     * Menu-related components.
     */
    menuBar ( true, JMenuBar.class, "MenuBarUI", WebLookAndFeel.menuBarUI ),
    menu ( true, JMenu.class, "MenuUI", WebLookAndFeel.menuUI ),
    popupMenu ( true, JPopupMenu.class, "PopupMenuUI", WebLookAndFeel.popupMenuUI ),
    menuItem ( true, JMenuItem.class, "MenuItemUI", WebLookAndFeel.menuItemUI ),
    checkBoxMenuItem ( true, JCheckBoxMenuItem.class, "CheckBoxMenuItemUI", WebLookAndFeel.checkBoxMenuItemUI ),
    radioButtonMenuItem ( true, JRadioButtonMenuItem.class, "RadioButtonMenuItemUI", WebLookAndFeel.radioButtonMenuItemUI ),
    popupMenuSeparator ( true, JPopupMenu.Separator.class, "PopupMenuSeparatorUI", WebLookAndFeel.popupMenuSeparatorUI ),

    /**
     * Separator component.
     */
    separator ( true, JSeparator.class, "SeparatorUI", WebLookAndFeel.separatorUI ),

    /**
     * Scroll-related components.
     */
    scrollBar ( true, JScrollBar.class, "ScrollBarUI", WebLookAndFeel.scrollBarUI ),
    scrollPane ( true, JScrollPane.class, "ScrollPaneUI", WebLookAndFeel.scrollPaneUI ),
    viewport ( true, JViewport.class, "ViewportUI", WebLookAndFeel.viewportUI ),

    /**
     * Text-related components.
     */
    textField ( true, JTextField.class, "TextFieldUI", WebLookAndFeel.textFieldUI ),
    passwordField ( true, JPasswordField.class, "PasswordFieldUI", WebLookAndFeel.passwordFieldUI ),
    formattedTextField ( true, JFormattedTextField.class, "FormattedTextFieldUI", WebLookAndFeel.formattedTextFieldUI ),
    textArea ( true, JTextArea.class, "TextAreaUI", WebLookAndFeel.textAreaUI ),
    editorPane ( true, JEditorPane.class, "EditorPaneUI", WebLookAndFeel.editorPaneUI ),
    textPane ( true, JTextPane.class, "TextPaneUI", WebLookAndFeel.textPaneUI ),

    /**
     * Toolbar-related components.
     */
    toolBar ( true, JToolBar.class, "ToolBarUI", WebLookAndFeel.toolBarUI ),
    toolBarSeparator ( true, JToolBar.Separator.class, "ToolBarSeparatorUI", WebLookAndFeel.toolBarSeparatorUI ),

    /**
     * Table-related components.
     */
    table ( true, JTable.class, "TableUI", WebLookAndFeel.tableUI ),
    tableHeader ( true, JTableHeader.class, "TableHeaderUI", WebLookAndFeel.tableHeaderUI ),

    /**
     * Chooser components.
     */
    colorChooser ( true, JColorChooser.class, "ColorChooserUI", WebLookAndFeel.colorChooserUI ),
    fileChooser ( true, JFileChooser.class, "FileChooserUI", WebLookAndFeel.fileChooserUI ),

    /**
     * Container-related components.
     */
    panel ( true, JPanel.class, "PanelUI", WebLookAndFeel.panelUI ),
    rootPane ( true, JRootPane.class, "RootPaneUI", WebLookAndFeel.rootPaneUI ),
    tabbedPane ( true, JTabbedPane.class, "TabbedPaneUI", WebLookAndFeel.tabbedPaneUI ),
    splitPane ( true, JSplitPane.class, "SplitPaneUI", WebLookAndFeel.splitPaneUI ),

    /**
     * Other data-related components.
     */
    progressBar ( true, JProgressBar.class, "ProgressBarUI", WebLookAndFeel.progressBarUI ),
    slider ( true, JSlider.class, "SliderUI", WebLookAndFeel.sliderUI ),
    spinner ( true, JSpinner.class, "SpinnerUI", WebLookAndFeel.spinnerUI ),
    tree ( true, JTree.class, "TreeUI", WebLookAndFeel.treeUI ),
    list ( true, JList.class, "ListUI", WebLookAndFeel.listUI ),
    comboBox ( true, JComboBox.class, "ComboBoxUI", WebLookAndFeel.comboBoxUI ),

    /**
     * Desktop-pane-related components.
     */
    desktopPane ( true, JDesktopPane.class, "DesktopPaneUI", WebLookAndFeel.desktopPaneUI ),
    desktopIcon ( true, JInternalFrame.JDesktopIcon.class, "DesktopIconUI", WebLookAndFeel.desktopIconUI ),
    internalFrame ( true, JInternalFrame.class, "InternalFrameUI", WebLookAndFeel.internalFrameUI ),

    /**
     * Option pane component.
     */
    optionPane ( true, JOptionPane.class, "OptionPaneUI", WebLookAndFeel.optionPaneUI );

    /**
     * Component type icons cache.
     */
    private static final Map<SupportedComponent, ImageIcon> componentIcons =
            new EnumMap<SupportedComponent, ImageIcon> ( SupportedComponent.class );

    /**
     * Lazily initialized component types map by their UI class IDs.
     */
    private static final Map<String, SupportedComponent> componentByUIClassID =
            new HashMap<String, SupportedComponent> ( values ().length );

    /**
     * Lazily initialized component types map by their UI classes.
     */
    private static final Map<Class<? extends ComponentUI>, SupportedComponent> componentByUIClass =
            new HashMap<Class<? extends ComponentUI>, SupportedComponent> ( values ().length );

    /**
     * Enum constant settings.
     */
    protected final boolean supportsPainters;
    protected final Class<? extends JComponent> componentClass;
    protected final String uiClassID;
    protected final String defaultUIClass;
    protected final StyleId defaultStyleId;

    /**
     * Constructs a reference to component with specified settings.
     *
     * @param supportsPainters whether this component supports painters or not
     * @param componentClass   component class for this component type
     * @param uiClassID        UI class ID used by LookAndFeel to store various settings
     * @param defaultUIClass   default UI class canonical name
     */
    private SupportedComponent ( final boolean supportsPainters, final Class<? extends JComponent> componentClass, final String uiClassID,
                                 final String defaultUIClass )
    {
        this.supportsPainters = supportsPainters;
        this.componentClass = componentClass;
        this.uiClassID = uiClassID;
        this.defaultUIClass = defaultUIClass;
        this.defaultStyleId = StyleId.of ( this.name ().toLowerCase () );
    }

    /**
     * Returns whether this component type supports painters or not.
     *
     * @return true if this component type supports painters, false otherwise
     */
    public boolean supportsPainters ()
    {
        return supportsPainters;
    }

    /**
     * Returns component class for this component type.
     *
     * @return component class for this component type
     */
    public Class<? extends JComponent> getComponentClass ()
    {
        return componentClass;
    }

    /**
     * Returns UI class ID used by LookAndFeel to store various settings.
     *
     * @return UI class ID
     */
    public String getUIClassID ()
    {
        return uiClassID;
    }

    /**
     * Returns default UI class canonical name.
     * This value is used in WebLookAndFeel to provide default UI classes.
     * However they can be reassigned before WebLookAndFeel installation.
     *
     * @return default UI class canonical name
     */
    public String getDefaultUIClass ()
    {
        return defaultUIClass;
    }

    /**
     * Returns UI class for this component type.
     * Result of this method is not cached because UI classes might be changed in runtime.
     *
     * @return UI class for this component type
     */
    public Class<? extends ComponentUI> getUIClass ()
    {
        final Class type = ReflectUtils.getClassSafely ( UIManager.getString ( getUIClassID () ) );
        final Class defaultType = ReflectUtils.getClassSafely ( getDefaultUIClass () );
        return ReflectUtils.isAssignable ( defaultType, type ) ? type : defaultType;
    }

    /**
     * Returns default style ID for this component type.
     *
     * @return default style ID for this component type
     */
    public StyleId getDefaultStyleId ()
    {
        return defaultStyleId;
    }

    /**
     * Returns component type icon.
     *
     * @return component type icon
     */
    public ImageIcon getIcon ()
    {
        if ( componentIcons.containsKey ( this ) )
        {
            return componentIcons.get ( this );
        }
        else
        {
            try
            {
                final ImageIcon icon = new ImageIcon ( SupportedComponent.class.getResource ( "icons/component/" + this + ".png" ) );
                componentIcons.put ( this, icon );
                return icon;
            }
            catch ( final Throwable e )
            {
                Log.get ().error ( "Unable to find component icon: " + this, e );
                componentIcons.put ( this, null );
                return null;
            }
        }
    }

    /**
     * Returns supported component type by UI class ID.
     *
     * @param uiClassID UI class ID
     * @return supported component type by UI class ID
     */
    public static SupportedComponent getComponentTypeByUIClassID ( final String uiClassID )
    {
        if ( componentByUIClassID.size () == 0 )
        {
            for ( final SupportedComponent supportedComponent : values () )
            {
                componentByUIClassID.put ( supportedComponent.getUIClassID (), supportedComponent );
            }
        }
        return componentByUIClassID.get ( uiClassID );
    }

    /**
     * Returns supported component type by UI class ID.
     *
     * @param uiClassID UI class ID
     * @return supported component type by UI class ID
     */
    public static SupportedComponent getComponentTypeByUIClass ( final Class<? extends ComponentUI> uiClass )
    {
        SupportedComponent type = componentByUIClass.get ( uiClass );
        if ( type == null )
        {
            for ( final SupportedComponent supportedComponent : values () )
            {
                final Class<? extends ComponentUI> typeClass = supportedComponent.getUIClass ();
                if ( ReflectUtils.isAssignable ( typeClass, uiClass ) )
                {
                    type = supportedComponent;
                    componentByUIClass.put ( uiClass, supportedComponent );
                    break;
                }
            }
        }
        return type;
    }

    /**
     * Returns list of component types which supports painters.
     *
     * @return list of component types which supports painters
     */
    public static List<SupportedComponent> getPainterSupportedComponents ()
    {
        final List<SupportedComponent> supportedComponents = new ArrayList<SupportedComponent> ();
        for ( final SupportedComponent sc : SupportedComponent.values () )
        {
            if ( sc.supportsPainters () )
            {
                supportedComponents.add ( sc );
            }
        }
        return supportedComponents;
    }
}