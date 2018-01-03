import {Component, OnInit} from '@angular/core';
import {Response} from '@angular/http';
import {Router} from '@angular/router';
import * as Rx from 'rxjs/Rx';

import 'rxjs/add/operator/switchMap';

import {PaginationPage, PaginationPropertySort} from '../pagination';
import {Table} from '../table';
import {showLoading, hideLoading, doNothing} from '../commons'
import {CommitService} from '../commit.service';
import {Commit} from '../domain';


@Component({
    selector: 'app-commit-list',
    templateUrl: './commit-list.component.html',
    styleUrls: ['./commit-list.component.css']
})
export class CommitListComponent implements OnInit, Table<Commit> {

    now = new Date();

    commitPage: PaginationPage<Commit>;
    self: Table<Commit>;

    constructor(private commitService: CommitService, private router: Router) {

    }

    ngOnInit() {
        this.refreshPage();
    }

    refreshPage() {
        const observable: Rx.Observable<PaginationPage<any>> = this.fetchPage(0, 25, null);
        showLoading();
        observable.subscribe(doNothing, hideLoading, hideLoading);
        this.self = this;
    }

    fetchPage(pageNumber: number, pageSize: number, sort: PaginationPropertySort): Rx.Observable<PaginationPage<Commit>> {
        const observable: Rx.Observable<PaginationPage<Commit>> = this.commitService.findCommits(pageNumber, pageSize, sort);
        observable.subscribe(commitPage => this.commitPage = commitPage);
        return observable;
    }
}
