import { Component, ElementRef, Injector, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { OntimizeService } from 'ontimize-web-ngx';

@Component({
  selector: 'app-competitions-search',
  templateUrl: './competitions-search.component.html',
  styleUrls: ['./competitions-search.component.scss']
})
export class CompetitionsSearchComponent implements OnInit {

  protected service: OntimizeService;
  
  @ViewChild("privateComp", { static: true }) code: ElementRef;

  constructor(protected injector: Injector, private router: Router) {
    this.service = this.injector.get(OntimizeService);
  }

  ngOnInit() {
    this.configureService();
  }

  protected configureService() {
    const conf = this.service.getDefaultServiceConfiguration('competitions');
    this.service.configureService(conf);
  }

  searchPrivate() {
    this.service.query({ "COMP_CODE": this.code.nativeElement.value, "COMP_ISPUBLIC": false },
     ["COMP_ID"], "competition").subscribe(resp => {
      const competitionId = resp.data[0].COMP_ID;
      const url = `/main/home/${competitionId}?isdetail=true`;
      this.router.navigateByUrl(url);
    });
  }

}
