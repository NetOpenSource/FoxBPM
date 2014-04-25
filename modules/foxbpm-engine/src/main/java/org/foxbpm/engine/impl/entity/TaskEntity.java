package org.foxbpm.engine.impl.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.foxbpm.engine.db.HasRevision;
import org.foxbpm.engine.db.PersistentObject;
import org.foxbpm.engine.impl.task.TaskDefinition;
import org.foxbpm.engine.task.DelegationState;
import org.foxbpm.engine.task.Task;
import org.foxbpm.engine.task.TaskType;
import org.foxbpm.kernel.process.KernelFlowNode;
import org.foxbpm.kernel.runtime.impl.KernelVariableScopeImpl;

public class TaskEntity extends KernelVariableScopeImpl implements Task, PersistentObject, HasRevision {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String id;

	protected String name;

	
	protected String description;

	protected String processInstanceId;

	protected String processDefinitionId;

	protected String processDefinitionKey;

	protected String processDefinitionName;

	protected int version;

	protected String tokenId;

	protected String nodeId;

	protected String nodeName;

	protected String parentId;

	protected String assignee;

	protected Date claimTime;

	protected Date createTime;

	protected Date startTime;

	protected Date endTime;

	protected Date dueDate;

	protected boolean isBlocking = false;

	protected int priority = Task.PRIORITY_NORMAL;

	protected String category;

	protected String owner;

	protected DelegationState delegationState;

	protected String bizKey;

	protected String taskComment;

	protected String formUri;

	protected String formUriView;

	protected String taskGroup;

	protected String taskType = TaskType.FOXBPMTASK;

	protected boolean isCancelled = false;

	protected boolean isSuspended = false;

	protected boolean isOpen = true;

	protected boolean isDraft = false;

	protected int expectedExecutionTime = 0;

	protected String agent;

	protected String admin;

	protected String callActivityInstanceId;

	protected String pendingTaskId;

	protected Date archiveTime;

	protected String commandId;

	protected String commandType;

	protected String commandMessage;
	
	
	protected TokenEntity token;

	protected ProcessInstanceEntity processInstance;

	protected KernelFlowNode node;

	protected TaskDefinition taskDefinition;

	protected List<IdentityLinkEntity> taskIdentityLinks=new ArrayList<IdentityLinkEntity>();

	protected TaskEntity parentTask;

	

	public ProcessInstanceEntity getProcessInstance() {
		return processInstance;
	}

	public void setProcessInstance(ProcessInstanceEntity processInstance) {
		setProcessInstanceId(processInstance.getId());
		setProcessDefinitionId(processInstance.getProcessDefinitionId());
		setProcessDefinitionKey(processInstance.getProcessDefinitionKey());
		this.processInstance = processInstance;
	}

	
	
	public TokenEntity getToken() {
		return token;
	}

	public void setToken(TokenEntity token) {
		setTokenId(token.getId());
		setProcessInstance(token.getProcessInstance());
		this.token = token;
	}

	public KernelFlowNode getNode() {
		return node;
	}

	public void setNode(KernelFlowNode node) {
		setNodeId(node.getId());
		this.node = node;
	}

	public TaskDefinition getTaskDefinition() {
		return taskDefinition;
	}

	public void setTaskDefinition(TaskDefinition taskDefinition) {
		this.taskDefinition = taskDefinition;
	}

	public List<IdentityLinkEntity> getTaskIdentityLinks() {
		return taskIdentityLinks;
	}

	public void setTaskIdentityLinks(List<IdentityLinkEntity> taskIdentityLinks) {
		this.taskIdentityLinks = taskIdentityLinks;
	}

	public TaskEntity getParentTask() {
		return parentTask;
	}

	public void setParentTask(TaskEntity parentTask) {
		this.parentTask = parentTask;
	}
	

	public DelegationState getDelegationState() {
		return delegationState;
	}

	public void setDelegationState(DelegationState delegationState) {
		this.delegationState = delegationState;
	}

	public String getDelegationStateString() {
		return (delegationState != null ? delegationState.toString() : null);
	}

	public void setDelegationStateString(String delegationStateString) {
		this.delegationState = (delegationStateString != null ? 
				DelegationState.valueOf(DelegationState.class, delegationStateString)
				: null);
	}

	public void setRevision(int revision) {
		// TODO Auto-generated method stub

	}

	public int getRevision() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getRevisionNext() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Object> getPersistentState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected KernelVariableScopeImpl getParentVariableScope() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void ensureParentInitialized() {
		// TODO Auto-generated method stub

	}

	public boolean isModified() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getProcessDefinitionId() {
		return processDefinitionId;
	}

	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}

	public String getProcessDefinitionKey() {
		return processDefinitionKey;
	}

	public void setProcessDefinitionKey(String processDefinitionKey) {
		this.processDefinitionKey = processDefinitionKey;
	}

	public String getProcessDefinitionName() {
		return processDefinitionName;
	}

	public void setProcessDefinitionName(String processDefinitionName) {
		this.processDefinitionName = processDefinitionName;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public Date getClaimTime() {
		return claimTime;
	}

	public void setClaimTime(Date claimTime) {
		this.claimTime = claimTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isBlocking() {
		return isBlocking;
	}

	public void setBlocking(boolean isBlocking) {
		this.isBlocking = isBlocking;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getBizKey() {
		return bizKey;
	}

	public void setBizKey(String bizKey) {
		this.bizKey = bizKey;
	}

	public String getTaskComment() {
		return taskComment;
	}

	public void setTaskComment(String taskComment) {
		this.taskComment = taskComment;
	}

	public String getFormUri() {
		return formUri;
	}

	public void setFormUri(String formUri) {
		this.formUri = formUri;
	}

	public String getFormUriView() {
		return formUriView;
	}

	public void setFormUriView(String formUriView) {
		this.formUriView = formUriView;
	}

	public String getTaskGroup() {
		return taskGroup;
	}

	public void setTaskGroup(String taskGroup) {
		this.taskGroup = taskGroup;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public boolean isCancelled() {
		return isCancelled;
	}

	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}

	public boolean isSuspended() {
		return isSuspended;
	}

	public void setSuspended(boolean isSuspended) {
		this.isSuspended = isSuspended;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public boolean isDraft() {
		return isDraft;
	}

	public void setDraft(boolean isDraft) {
		this.isDraft = isDraft;
	}

	public int getExpectedExecutionTime() {
		return expectedExecutionTime;
	}

	public void setExpectedExecutionTime(int expectedExecutionTime) {
		this.expectedExecutionTime = expectedExecutionTime;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getCallActivityInstanceId() {
		return callActivityInstanceId;
	}

	public void setCallActivityInstanceId(String callActivityInstanceId) {
		this.callActivityInstanceId = callActivityInstanceId;
	}

	public String getPendingTaskId() {
		return pendingTaskId;
	}

	public void setPendingTaskId(String pendingTaskId) {
		this.pendingTaskId = pendingTaskId;
	}

	public Date getArchiveTime() {
		return archiveTime;
	}

	public void setArchiveTime(Date archiveTime) {
		this.archiveTime = archiveTime;
	}

	public String getCommandId() {
		return commandId;
	}

	public void setCommandId(String commandId) {
		this.commandId = commandId;
	}

	public String getCommandType() {
		return commandType;
	}

	public void setCommandType(String commandType) {
		this.commandType = commandType;
	}

	public String getCommandMessage() {
		return commandMessage;
	}

	public void setCommandMessage(String commandMessage) {
		this.commandMessage = commandMessage;
	}


}