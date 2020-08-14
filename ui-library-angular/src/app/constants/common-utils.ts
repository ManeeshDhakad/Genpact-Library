export class CommonUtils {
    public cloneObject(object : any) {
        return JSON.parse(JSON.stringify(object));
    }
}
