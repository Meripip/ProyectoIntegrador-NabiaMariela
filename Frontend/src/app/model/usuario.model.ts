export class usuario{
    id?: number;
    nombre: String;
    apellido: String;
    imgPerfil: String;
    
    constructor(nombre: String,apellido: String,imgPerfil: String){
        this.nombre = nombre;
        this.apellido = apellido;
        this.imgPerfil = imgPerfil;
    }
}