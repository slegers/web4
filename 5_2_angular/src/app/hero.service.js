"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
var core_1 = require("@angular/core");
require("rxjs/Rx");
var Rx_1 = require("rxjs/Rx");
var HeroService = (function () {
    function HeroService(http) {
        this.http = http;
        this.heroesUrl = 'http://localhost:8080/Heroes/Controller';
    }
    HeroService.prototype.getHeroes = function () {
        var _this = this;
        return Rx_1.Observable
            .interval(5000)
            .flatMap(function () { return _this.http.get(_this.heroesUrl).map(function (data) { return data.json(); }); });
    };
    return HeroService;
}());
HeroService = __decorate([
    core_1.Injectable()
], HeroService);
exports.HeroService = HeroService;
