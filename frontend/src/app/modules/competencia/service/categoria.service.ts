import { Observable } from 'rxjs';
import { SelecionaModel } from './../../seleciona/models/seleciona.models';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

    constructor(private http: HttpClient) { }

    protected UrlService: string = environment.apiUrl;

    public getCategorias(): Observable<SelecionaModel[]>{
        return this.http.get<SelecionaModel[]>(this.UrlService + "/categorias")
    }

}
