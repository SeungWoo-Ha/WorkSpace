<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page import="org.apache.commons.fileupload.FileUpload" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="java.io.*" %>
<html>
	<head>
		<title>���� ���ε� ó��</title>
	</head>
	<body>
<%
	DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
	String temporaryDir="C://temp";
	File repositoryPath=new File(temporaryDir);
	diskFileItemFactory.setRepository(repositoryPath);
	//100K������ �޸𸮿� ����
	diskFileItemFactory.setSizeThreshold(1024*100);
	ServletFileUpload fileUpload=new ServletFileUpload(diskFileItemFactory);
	if(ServletFileUpload.isMultipartContent(request)){
		/*FileItem�� ����Ʈ*/
		java.util.List fileItemList=fileUpload.parseRequest(request);
		for(int i=0;i<fileItemList.size();i++){
			FileItem fileItem=(FileItem)fileItemList.get(i);
			if(fileItem.isFormField()){//���� �̿��� �Ķ����
%>
		�� �Ķ���� : <%=fileItem.getFieldName() %>=<%=fileItem.getString() %><br/>
<%		}else{//������ ���%>
		���� : <%=fileItem.getFieldName() %>=<%=fileItem.getName() %>(<%=fileItem.getSize() %>bytes)<br/>
<%			if(fileItem.isInMemory()){ %>
				�޸𸮿� ����<br/>
<%			}else{ %>
				��ũ�� ����<br/>
<%			} %>
<%
				String filePath=application.getRealPath("upload");
				//���ε��� ������ �����ϴ� ���
				if(fileItem.getSize()>0){
					int idx=fileItem.getName().lastIndexOf("\\");
					if(idx==-1){
						idx=fileItem.getName().lastIndexOf("/");
					}
					String fileName=fileItem.getName().substring(idx+1);
					try{
						File uploadFile=new File(filePath,fileName);
						fileItem.write(uploadFile);
					}catch(IOException ex){
						//����ó��
					}finally{
						fileItem.delete();
					}
				}
			}
		}
	}else{
%>
		���ڵ� Ÿ���� multipart/form-data�� �ƴ�.
<%}%>
	</body>
</html>