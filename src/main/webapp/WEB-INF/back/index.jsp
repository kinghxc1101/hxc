<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<head id="Head1">
<title>�����޺�̨����ϵͳ</title>
<meta http-equiv="Content-Type" content="text/html charset=gbk" />
<link href="/static/public/css/default.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" type="text/css"
	href="/static/public/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="/static/public/js/themes/icon.css" />
<script type="text/javascript"
	src="/static/public/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="/static/public/js/jQuery.easyui.js"></script>

<script type="text/javascript" src='/static/public/js/outlook2.js'></script>
<script type="text/javascript">
	 var _menus = {"menus":[
			{"menuid":"1","icon":"icon-sys","menuname":"���ݹ���",
				"menus":[ 
					
						 <shiro:hasPermission name="newsDinamic:view"> 
				         {"menuname":"ý����Ƶ����","url":"/admin/media/list.jhtml"},
				        </shiro:hasPermission> 
						<shiro:hasPermission name="newsDinamic:view"> 
				         {"menuname":"��ҵ���Ź���","url":"/admin/news/list.jhtml"},
				        </shiro:hasPermission>
						<shiro:hasPermission name="business:view"> 
				         {"menuname":"����Χ����","url":"/admin/media/list.jhtml"},
				        </shiro:hasPermission>
						<shiro:hasPermission name="example:view"> 
				         {"menuname":"��ҵ��������","url":"/admin/media/list.jhtml"},
				        </shiro:hasPermission>
						<shiro:hasPermission name="contact:view"> 
				         {"menuname":"�û���ѯ����","url":"/admin/media/list.jhtml"},
				        </shiro:hasPermission>
						<shiro:hasPermission name="partners:view"> 
				         {"menuname":"����������","url":"/admin/media/list.jhtml"},
				        </shiro:hasPermission>
						<shiro:hasPermission name="companyMsg:view"> 
				         {"menuname":"��ҵ��Ϣ����","url":"/admin/media/list.jhtml"},
				        </shiro:hasPermission>
						<shiro:hasPermission name="team:view"> 
				         {"menuname":"�����Ŷӹ���","url":"/admin/media/list.jhtml"},
				        </shiro:hasPermission>
						<shiro:hasPermission name="banner:view"> 
				         {"menuname":"banner����","url":"/admin/media/list.jhtml"},
				        </shiro:hasPermission>
						<shiro:hasPermission name="process:view"> 
				         {"menuname":"��ҵ���̹���","url":"/admin/media/list.jhtml"},
				        </shiro:hasPermission>
						<shiro:hasPermission name="ourcustomer:view"> 
				         {"menuname":"��ҵ�ͻ�����","url":"/admin/media/list.jhtml"},
				        </shiro:hasPermission>
						<shiro:hasPermission name="contactus:view"> 
				         {"menuname":"�������ǹ���","url":"/admin/media/list.jhtml"},
				        </shiro:hasPermission>
						<shiro:hasPermission name="addAdmin:view"> 
				         {"menuname":"��ӹ���Ա","url":"/admin/media/list.jhtml"},
				        </shiro:hasPermission>
						
]
			}
			,{"menuid":"2","icon":"icon-sys","menuname":"ϵͳ����",
				"menus":[<shiro:hasPermission name="addAdmin:view"> 
				        {"menuname":"��ɫ����","icon":"icon-log","url":"/admin/roleList.jhtml"},
				        </shiro:hasPermission>
				        <shiro:hasPermission name="addAdmin:view"> 
						{"menuname":"����Ա����","icon":"icon-log","url":"/admin/adminList.jhtml"}
						</shiro:hasPermission>
					]
			}
			
	]};
        //���õ�¼����
        function openPwd() {
            $('#w').window({
                title: '�޸�����',
                width: 300,
                modal: true,
                shadow: true,
                closed: true,
                height: 160,
                resizable:false
            });
        }
        //�رյ�¼����
        function close() {
            $('#w').window('close');
        }

        

        //�޸�����
        function serverLogin() {
            var $newpass = $('#txtNewPass');
            var $rePass = $('#txtRePass');

            if ($newpass.val() == '') {
                msgShow('ϵͳ��ʾ', '���������룡', 'warning');
                return false;
            }
            if ($rePass.val() == '') {
                msgShow('ϵͳ��ʾ', '����һ���������룡', 'warning');
                return false;
            }

            if ($newpass.val() != $rePass.val()) {
                msgShow('ϵͳ��ʾ', '�������벻һ��������������', 'warning');
                return false;
            }
	        // ajax ҳ����ˢ�µ��ú�̨����
            $.post('/admin/updatePwd.jhtml?newpass=' + $newpass.val(), function(msg) {
                msgShow('ϵͳ��ʾ', '��ϲ�������޸ĳɹ���<br>����������Ϊ��' + msg, 'info');
                $newpass.val('');
                $rePass.val('');
                close();
            });
            
        }

        $(function() {

            openPwd();
            //
            $('#editpass').click(function() {
                $('#w').window('open');
            });

            $('#btnEp').click(function() {
                serverLogin();
            })

           

            $('#loginOut').click(function() {
                $.messager.confirm('ϵͳ��ʾ', '��ȷ��Ҫ�˳����ε�¼��?', function(r) {

                    if (r) {
                        location.href = '/admin/logout.jhtml';
                    }
                });

            })
			
			
			
        });
		
		$(function(){
			$(".panel div").each(function(){
				//$(this).removeClass("accordion-header-selected");
			});
		});

    </script>

</head>
<body class="easyui-layout" style="overflow-y: hidden" scroll="no">
	<noscript>
		<div
			style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
			<img src="static/public/images/noscript.gif" alt='��Ǹ���뿪���ű�֧�֣�' />
		</div>
	</noscript>
	<div region="north" split="true" border="false"
		style="overflow: hidden; height: 30px;
        background: url(/static/public/images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, ΢���ź�,����">
		<span style="float:right; padding-right:20px;" class="head">��ӭ
			admin <a href="#" id="editpass">�޸�����</a> <a href="#" id="loginOut">��ȫ�˳�</a>
		</span> <span style="padding-left:10px; font-size: 16px; " />
	</div>
	<div region="south" split="true"
		style="height: 30px; background: #D2E0F2; ">
		<div class="footer"></div>
	</div>
	<div region="west" split="true" title="�����˵�" style="width:180px;"
		id="west">
		<div class="easyui-accordion" fit="true" border="false">
			<!--  �������� -->

		</div>

	</div>
	<div id="mainPanle" region="center"
		style="background: #eee; overflow-y:hidden">
		<div id="tabs" class="easyui-tabs" fit="true" border="false">
			<div title="��ӭʹ��" style="padding:20px;overflow:hidden;" id="home">

				<h1 style="font-size: 40px;">��ӭ��½��̨</h1>
			</div>
		</div>
	</div>


	<!--�޸����봰��-->
	<div id="w" class="easyui-window" title="�޸�����" collapsible="false"
		minimizable="false" maximizable="false" icon="icon-save"
		style="width: 300px; height: 150px; padding: 5px;
        background: #fafafa;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<table cellpadding=3>
					<tr>
						<td>�����룺</td>
						<td><input id="txtNewPass" type="password" class="txt01" />
						</td>
					</tr>
					<tr>
						<td>ȷ�����룺</td>
						<td><input id="txtRePass" type="password" class="txt01" /></td>
					</tr>
				</table>
			</div>
			<div region="south" border="false"
				style="text-align: right; height: 30px; line-height: 30px;">
				<a id="btnEp" class="easyui-linkbutton" icon="icon-ok"
					href="javascript:void(0)"> ȷ��</a> <a class="easyui-linkbutton"
					icon="icon-cancel" href="javascript:void(0)" onclick="closeLogin()">ȡ��</a>
			</div>
		</div>
	</div>

	<div id="mm" class="easyui-menu" style="width:150px;">
		<div id="mm-tabclose">�ر�</div>
		<div id="mm-tabcloseall">ȫ���ر�</div>
		<div id="mm-tabcloseother">����֮��ȫ���ر�</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">��ǰҳ�Ҳ�ȫ���ر�</div>
		<div id="mm-tabcloseleft">��ǰҳ���ȫ���ر�</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">�˳�</div>
	</div>


</body>
</html>