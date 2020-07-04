


public class MainClient {

    public static void main(String[] args) {
        Profile juan = new Profile();
        juan.setFullName("Juan Leyva");
        juan.setUserName("Empe");
        juan.setDescription("Manco en el Fortnite");
        juan.setGender("Masculino");
        juan.setEmailAddress("empe_ley@gmail.com");
        juan.setPhoneNumber("2240353");


        //Hacer algo con Juan
        System.out.println("Ingresando al sistema:"+juan.getFullName());


        Profile maria = juan.creaPrototype();

        maria.setFullName("María Fernanda");
        System.out.println("Ingresando al sistema:"+maria.getFullName);

        //ingresar a Maria al sistema....

    }
}
