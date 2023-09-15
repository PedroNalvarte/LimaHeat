package general;

import general.conexion.ConectaDb;

public class Transversal {
    
    protected final ConectaDb DB;
    protected String message;

    public Transversal() {
        this.DB = new ConectaDb();
    }
}
