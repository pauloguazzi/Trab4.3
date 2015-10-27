/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.validate;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Paulo Guazzi
 */
@FacesValidator("CPFValidator")
public class CPFValidator implements Validator {
    public void validate(FacesContext context, UIComponent component, 
                         Object value) {
    
        String cpf = value.toString();
        if (!((cpf.matches("[0-9]*")) || 
           ((cpf.substring(0,8).matches("[0-9]*")) && (cpf.substring(10,11).matches("[0-9]*"))&& cpf.contains("-")) || 
           ((cpf.substring(0,2).matches("[0-9]*"))&& (cpf.substring(4,6).matches("[0-9]*")) && (cpf.substring(8,10).matches("[0-9]*"))&& (cpf.substring(12,13).matches("[0-9]*"))&& (cpf.substring(3).contains(".")) && (cpf.substring(7).contains(".")) && (cpf.substring(11).contains("-")))));
        
        FacesMessage msg =  new FacesMessage("CPF '"+ cpf + "' inválido.");
            throw new ValidatorException(msg);
    }
}
