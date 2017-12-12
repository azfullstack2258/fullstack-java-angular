import {Injectable} from '@angular/core';
import {Commit} from './domain';
import {PaginationPage, PaginationPropertySort} from './pagination';
import {webServiceEndpoint} from './commons';
import {Http, Response, URLSearchParams, RequestOptions} from '@angular/http';
import {Resolve, RouterStateSnapshot, ActivatedRouteSnapshot} from '@angular/router';
import * as Rx from "rxjs/Rx";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/publish';

@Injectable()
export class CommitService implements Resolve<Commit>{

    constructor(private http: Http) {

    }

    findCommits(page: number, pageSize: number, sort: PaginationPropertySort): Rx.Observable<PaginationPage<Commit>> {
        let params = new URLSearchParams();
        params.set('size', `${pageSize}`);
        params.set('page', `${page}`);
        if (sort != null) {
            params.set('sort', `${sort.property},${sort.direction}`);
        }

        let options = new RequestOptions({
            search: params
        });
        return this.http.get(`${webServiceEndpoint}/commit`, options).map(this.extractData).publish().refCount();
    }

    getCommit(id: number): Rx.Observable<Commit> {
        return this.http.get(`${webServiceEndpoint}/person/${id}`).map(this.extractData).publish().refCount();
    }

    resolve(route: ActivatedRouteSnapshot,state: RouterStateSnapshot): Rx.Observable<Commit> {
        return this.getCommit(Number(route.params['id']));
    }

    private extractData(res: Response) {
        let body = res.json();
        return body || {};
    }
}
