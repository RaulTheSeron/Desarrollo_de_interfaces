
package botonEfectosPack;

import java.awt.Component;
import java.beans.*;


public class efectoEditor extends PropertyEditorSupport {

    private editorPanel editor = null;
    
    //Constructor
    public efectoEditor() {
        editor = new editorPanel();
    }
    
    
    //Metodos sobreescritos
    @Override
    public String getAsText() {
        return super.getAsText();
    }
    @Override
    public Component getCustomEditor() {
        return editor;
    }

    @Override
    public String getJavaInitializationString() {
        String tipoEfecto =(String)getValue();
        return "\""+tipoEfecto+"\"";
    }
    
    @Override
    public String[] getTags() {
        String[] tags ={"Hover","Parpadeo","Ninguno"};
        return tags;  
    }
    
    @Override
    public Object getValue() {    
        if (editor.isShowing()){
            return editor.cmbEfecto.getSelectedItem().toString();
        }
        else{
            return super.getValue();
        }
    }
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text); 
    }
    
    @Override
    public void setValue(Object value) {
        if (value == null){
            value = new String();
        }
        super.setValue(value); ; 
    }
    
    @Override
    public boolean supportsCustomEditor() {
        return true;
    }


}
