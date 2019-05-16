/*封装ajax工具类*/
function ajaxUtil(typeValue, urlValue, dataValue, dataTypeValue, cacheValue, asyncValue, processDataValue) {
    var getData;
    $.ajax({
        type: typeValue,
        url: urlValue,
        cache: cacheValue == null ? false : cacheValue,
        async: asyncValue == null ? true : asyncValue,
        data: dataValue == null ? "" : dataValue,
        dataType: dataTypeValue,
        processData: processDataValue == null ? false : processDataValue,
        success: function (res) {
            getData =res;
        }, error: function (res) {
            console.log(res);
        }
    });
    return getData;
}