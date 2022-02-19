import { CompetenciaModel } from './../models/competencia.models';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CompetenciaService {

   constructor(private http: HttpClient) { }

   protected UrlService: string = environment.apiUrl;

   public listarCompetencias(): Observable<CompetenciaModel[]>{
       return this.http.get<CompetenciaModel[]>(this.UrlService + "/competencias")
   }






}
