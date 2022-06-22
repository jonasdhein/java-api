/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaApi;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import jdk.nashorn.internal.parser.JSONParser;

/**
 *
 * @author jdhein
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         try{
            
            URL url = new URL("https://viacep.com.br/ws/95890000/json/");
            URLConnection connection = url.openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            
            String cep = "";
            StringBuilder jsonCep = new StringBuilder();
            
            while((cep = buffer.readLine()) != null){
                jsonCep.append(cep);
            }
            
            System.out.println("RET: " + jsonCep.toString());
            
            Gson gson = new Gson();
            CepModel objCep = gson.fromJson(jsonCep.toString(), CepModel.class);

             System.out.println("Resultado: " + objCep.getLocalidade());
        }catch(Exception ex){
            
        }
        
    }
    
}
