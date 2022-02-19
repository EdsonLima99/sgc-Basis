import { TableModule } from 'primeng/table';
import { NgModule } from '@angular/core';
import { PRIMENG_IMPORTS } from './primeng-imports';
import { DatatableModule } from '@nuvem/primeng-components';

@NgModule({
    imports: [
        PRIMENG_IMPORTS,
        TableModule,
        DatatableModule,

    ],
    providers: [],
    exports: [
        PRIMENG_IMPORTS,
    ]
})
export class SharedModule { }
