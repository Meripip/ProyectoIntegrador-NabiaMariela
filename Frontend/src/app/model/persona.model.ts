/* export class persona{
    id?: number;
    nombre: String;
    apellido: String;
    img: String;
    
    constructor(nombre: String,apellido: String,img: String){
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
    }
} */
export class Persona{
    id?: number;
    nombreE: string;
    apellidoE: string;
    imgE: string;
    descripE: string;
    tituloE: string;

    constructor(nombreE: string, apellidoE: string, imgE: string, descripE: string, tituloE: string){
        this.nombreE = nombreE;
        this.apellidoE = apellidoE;
        this.imgE = imgE;
        this.descripE = descripE;
        this.tituloE = tituloE;
    }
}