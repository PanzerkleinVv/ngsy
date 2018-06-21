package com.gdin.dzzwsyb.ngsy.web.model;

public class Node {


    private String id;    //树的节点Id，区别于数据库中保存的数据Id。
    private String pId;
    private String name;   //节点名称
    private boolean open;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
    
    
   
   
    
   /* *//**
     * 生成一颗多叉树，根节点为root
     * @param Nodes 生成多叉树的节点集合
     * @return root
     *//*
    public Node createTree(ArrayList<Node> Nodes) {
        if (Nodes == null || Nodes.size() < 0)
            return null;
        Node root = new Node("0","0");//根节点自定义，但是要和pid对应好
        // 将所有节点添加到多叉树中
        for (Node node : Nodes) {
            if (node.getPid().equals("0")) {//根节点自定义，但是要和pid对应好
                // 向根添加一个节点
                root.getNodes().add(node);
            } else {
                addChild(root, node);
            }
        }
        return root;
    }

    *//**
     * 向指定多叉树节点添加子节点
     * @param Node 多叉树节点
     * @param child 节点
     *//*
    public void addChild(Node Node, Node child) {
        for (Node item : Node.getNodes()) {
            if (item.getNodeId().equals(child.getPid())) {
                // 找到对应的父亲
                item.getNodes().add(child);
                break;
            } else {
                if (item.getNodes() != null && item.getNodes().size() > 0) {
                    addChild(item, child);
                }
            }
        }
    }

    *//**
     * 遍历多叉树
     * @param Node 多叉树节点
     * @return
     *//*
    public String iteratorTree(Node Node) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("\n");
        if (Node != null) {
            for (Node index : Node.getNodes()) {
                buffer.append(index.getNodeId() + ",");
                if (index.getNodes() != null && index.getNodes().size() > 0) {
                    buffer.append(iteratorTree(index));
                }
            }
        }
        buffer.append("\n");
        return buffer.toString();
    }*/
}
