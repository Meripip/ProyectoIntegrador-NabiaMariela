export class Skills {
    id: number;
    nombre: string;
    progreso: number;
    img: string;

    constructor(nombre:string, progreso:number, img:string){
        this.nombre = nombre;
        this.progreso = progreso;
        this.img = img;
    }
}
