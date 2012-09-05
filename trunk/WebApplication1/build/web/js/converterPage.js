ConverterPage=function(){
    converterPage={
        initActionANDListener:function(){
            $(".isInDel").change(function(){
                if($(this).val()==1){
                    $("input[name=inDelimter]").val('');
                    $("input[name=inDelimter]").show();
                    $("#inFldLenDiv").hide();
                }else{
                    $("input[name=inDelimter]").hide();
                    $("#inFldLenDiv").show();
                }
            });
            $(".isOutDel").change(function(){
                if($(this).val()==1){
                    $("input[name=outDelimter]").val('');
                    $("input[name=outDelimter]").show();
                }else{
                    $("input[name=outDelimter]").hide();
                }
            });
            $("#converterForm").submit(function(){
                //return false;
                });
            $("#updateinput").click(function(){
                var length=parseInt($("input[name=inFldlen]").val());
                converterPage.fillInputFieldsDetails(length,function(response){
                    $("#inFldsQuslenDiv").html(response);
                });
                return false;
            });
            $("#updateOutput").click(function(){
                var length=parseInt($("input[name=outFldlen]").val());
                converterPage.fillOnputFieldsDetails(length,function(response){
                    $("#OutFldsQuslenDiv").html(response);
                });
                return false;
            });
            $(".isHsOldFld").live('click',function(){
                var eid=$(this).attr('eid');
                if($(this).val()==1){
                    $("#outOldFld_"+eid).val('');
                    $("#outOldFld_"+eid).show();
                }else{
                    
                    $("#outOldFld_"+eid).hide();
                }
            })
        },
        fillInputFieldsDetails:function(length,callback){
            var out="";
            for(i=0;i<length;i++){
                out+="<div>";
                out+="<p>";
                out+="<label>what is field #"+(i+1)+"'s Length</label>";
                out+='<input type="text" name="inFldLenN_'+i+'" class="isInDel" />';
                out+='<input type="hidden" value="2" name="eshta" />';
                out+="</p></div>";
            }
            callback(out);
        },
        fillOnputFieldsDetails:function(length,callback){
            var out="";
            for(i=0;i<length;i++){
                out+="<div>";
                out+="<p>";
                out+="<label>what is field #"+(i+1)+"'s Length</label>";
                out+='<input type="text" name="outFldLenN_'+i+'" value="2" class="isInDel" />';
                out+="<p><label>if this field maped to old field</label></p>";
                out+="<p>"
                out+="<label>Yes</label>"
                out+='<input type="radio" eid="'+i+'" name="isHsOldFld_'+i+'" value="1" class="isHsOldFld"/>';
                out+='<input type="text" name="outOldFld_'+i+'" id="outOldFld_'+i+'"  style="display:none"/>';
                out+="</p>";
                out+="<p>";
                out+="<label>No</label>";
                out+='<input type="radio" eid="'+i+'" name="isHsOldFld_'+i+'" value="2" class="isHsOldFld" />';
                out+="</p>"
                out+="</p></div>";
            }
            callback(out);
        }
    }
    $(function(){
        converterPage.initActionANDListener();
    })
    return converterPage;
}
converterPage=new ConverterPage();