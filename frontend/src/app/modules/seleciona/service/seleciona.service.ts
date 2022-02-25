import { Observable } from 'rxjs';
import { SelecionaModel } from './../models/seleciona.models';
import { environment } from './../../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SelecionaService {

    constructor(private http: HttpClient) { }

    protected UrlService: string = environment.apiUrl;

    public getSenioridade(): Observable<SelecionaModel[]>{
        return this.http.get<SelecionaModel[]>(this.UrlService + '/senioridades')
    }

}
