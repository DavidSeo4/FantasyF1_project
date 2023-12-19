import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { CompetitionsEditTypeColumnRendererComponent } from '../main/competitions/competitions-team-edit/competitions-edit-type-column-renderer/competitions-edit-type-column-renderer.component';
import { CompetitionsResultsColumnRendererComponent } from '../main/competitions/competitions-results-history/competitions-results-column-renderer/competitions-results-column-renderer.component';
import { CompetitionsDetailRendererComponent } from '../main/competitions/competitions-detail/competitions-detail-renderer/competitions-detail-renderer.component';

@NgModule({
  imports: [
    OntimizeWebModule
  ],
  declarations: [
    CompetitionsEditTypeColumnRendererComponent,
    CompetitionsResultsColumnRendererComponent,
    CompetitionsDetailRendererComponent
  ],
  exports: [
    CommonModule,
    CompetitionsEditTypeColumnRendererComponent,
    CompetitionsResultsColumnRendererComponent,
    CompetitionsDetailRendererComponent
  ]
})
export class SharedModule { }
