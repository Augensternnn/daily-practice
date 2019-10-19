


		public static void levelOrder(Node root){
			if(root == null){
				return;
			}
			// 队列中不会出现null
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			while(!queue.isEmpty()){
				Node front = queue.poll();
				if(front.left != null){
					queue.add(front.left);
				}
				if(front.right != null){
					queue.add(front.right);
				}
			}
		}
	