import com.google.gson.annotations.SerializedName;

public class ConstructorConvertidor {

    @SerializedName("base_code")
    private String base_code; //BASE INICIAL
    @SerializedName("target_code")
    private String target_code;//BASE FINAL
    private double monto;
    @SerializedName("conversion_result")
    private String conversion_result;

    public ConstructorConvertidor(){

    }


    public ConstructorConvertidor(String base_code,String target_code,double monto){
        this.base_code=base_code;
        this.target_code=target_code;
        this.monto=monto;
    }

    public ConstructorConvertidor(ConsutrucorConvertidorRecord miCambioRecord) {
        this.base_code=miCambioRecord.base_code();
        this.target_code=miCambioRecord.target_code();
        this.conversion_result=miCambioRecord.conversion_result();
    }

    /*GEt y Set*/

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getConversion_result() {
        return conversion_result;
    }

    public void setConversion_result(String conversion_result) {
        this.conversion_result = conversion_result;
    }

    @Override
    public String toString() {
        return /*"conversion_result=" + */conversion_result;
    }
}
