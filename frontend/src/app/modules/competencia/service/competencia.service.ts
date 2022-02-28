import { Observable } from 'rxjs';
import { CompetenciaModel } from './../models/competencia.models';
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

   public inserirCompetencia(competencia: CompetenciaModel): Observable<CompetenciaModel>{
       return this.http.post<CompetenciaModel>(this.UrlService + "/competencias", competencia)
   }

   public editarCompetencia(id:number, competencia: CompetenciaModel): Observable<CompetenciaModel>{
       return this.http.put<CompetenciaModel>(this.UrlService + "/competencias/" + id, competencia)
}

   public deletarCompetencia(id: number):Observable<CompetenciaModel>{
        return this.http.delete<CompetenciaModel>(this.UrlService + "/competencias/" + id)
   }






}
