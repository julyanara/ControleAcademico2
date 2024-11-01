package domain;

import java.util.Date;

public class Matricula {

    protected Integer Codigo;
    protected Date DataMat;

    
    public Matricula(Date dataMat2) {
        DataMat = dataMat2;
    }

    public Integer getCodigo() {
        return Codigo;
    }
    public void setCodigo(Integer codigo) {
        Codigo = codigo;
    }
    public java.sql.Date getDataMat() {
        return DataMat;
    }
    public void setDataMat(Date dataMat) {
        DataMat = dataMat;
    }

    
    
}
