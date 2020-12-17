
INSERT INTO `mydb`.`grupo` (`id`, `nome`, `parametros`) VALUES ('1', 'Administrador', '');
INSERT INTO `mydb`.`grupo` (`id`, `nome`, `parametros`) VALUES ('2', 'Vendas', '');


INSERT INTO `mydb`.`restricao` (`id`, `nome`, `tela`, `consultar`, `cadastrar`, `alterar`, `excluir` , `grupo_id`) VALUES ('1', 'Vendas - Cadastrar Usuário', 'usuario/cadastroUsuario', true, true, true, false,  2);
INSERT INTO `mydb`.`restricao` (`id`, `nome`, `tela`, `consultar`, `cadastrar`, `alterar`, `excluir`, `grupo_id`) VALUES ('2', 'Vendas - Cadastrar Fornecedor', 'fornecedor/cadastroFornecedor', true, true, true, false, 2);


INSERT INTO `mydb`.`usuario` (`id`, `nome`, `email`, `senha`, `telefone`, `grupo_id`) VALUES ('999', 'Administrador', 'administrador@nexus.com', 'teste', '4199999999', '1');
INSERT INTO `mydb`.`usuario` (`id`, `nome`, `email`, `senha`, `telefone`, `grupo_id`) VALUES ('1', 'Vendedor', 'vendas@nexus.com', 'teste', '4199999999', '2');