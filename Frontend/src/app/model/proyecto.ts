export class Proyecto {
    id: number;
    nombreE: string;
    descripcionE: string;
    urlE: string;
    imgE: string;

    constructor(nombreE: string, descripcionE: string, urlE: string, imgE: string){
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.urlE = urlE;
        this.imgE = imgE;
    }
}