
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`grupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`grupo` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `parametros` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  `telefone` VARCHAR(11) NOT NULL,
  `grupo_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_table1_grupo_idx` (`grupo_id` ASC) VISIBLE,
  CONSTRAINT `fk_table1_grupo`
    FOREIGN KEY (`grupo_id`)
    REFERENCES `mydb`.`grupo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`restricao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`restricao` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `tela` VARCHAR(45) NOT NULL,
  `consultar` TINYINT NULL,
  `cadastrar` TINYINT NULL,
  `alterar` TINYINT NULL,
  `excluir` TINYINT NULL,
  `grupo_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_restricao_grupo1_idx` (`grupo_id` ASC) VISIBLE,
  CONSTRAINT `fk_restricao_grupo1`
    FOREIGN KEY (`grupo_id`)
    REFERENCES `mydb`.`grupo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`fornecedor` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `telefone` VARCHAR(11) NULL,
  `email` VARCHAR(45) NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cliente_usuario1_idx` (`usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `mydb`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`fones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`fones` (
  `id` INT NOT NULL,
  `numero` VARCHAR(11) NULL,
  `relacao` VARCHAR(45) NULL,
  `id_relacao` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`produto` (
  `id` INT NOT NULL,
  `descricao` VARCHAR(45) NULL,
  `codigo_de_barras` VARCHAR(45) NULL,
  `quantidade` INT NOT NULL,
  `preco_compra` DOUBLE NULL,
  `valor_venda` DOUBLE NULL,
  `margem_lucro` DOUBLE NULL,
  `fornecedor_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_produto_fornecedor1_idx` (`fornecedor_id` ASC) VISIBLE,
  CONSTRAINT `fk_produto_fornecedor1`
    FOREIGN KEY (`fornecedor_id`)
    REFERENCES `mydb`.`fornecedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cumpomfiscal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cumpomfiscal` (
  `id` INT NOT NULL,
  `data` VARCHAR(45) NULL,
  `total` DOUBLE NULL,
  `forma_pagamento` VARCHAR(45) NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cumpomfiscal_usuario1_idx` (`usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_cumpomfiscal_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `mydb`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`venda` (
  `id` VARCHAR(45) NOT NULL,
  `quantidade` INT NULL,
  `produto_id` INT NOT NULL,
  `cumpomfiscal_id` INT NOT NULL,
  INDEX `fk_venda_produto1_idx` (`produto_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  INDEX `fk_venda_cumpomfiscal1_idx` (`cumpomfiscal_id` ASC) VISIBLE,
  CONSTRAINT `fk_venda_produto1`
    FOREIGN KEY (`produto_id`)
    REFERENCES `mydb`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_cumpomfiscal1`
    FOREIGN KEY (`cumpomfiscal_id`)
    REFERENCES `mydb`.`cumpomfiscal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- -----------------------------------------------------

use mydb;


INSERT INTO `mydb`.`grupo` (`id`, `nome`, `parametros`) VALUES ('1', 'Administrador', '');
INSERT INTO `mydb`.`grupo` (`id`, `nome`, `parametros`) VALUES ('2', 'Vendas', '');


INSERT INTO `mydb`.`restricao` (`id`, `nome`, `tela`, `consultar`, `cadastrar`, `alterar`, `excluir` , `grupo_id`) VALUES ('1', 'Vendas - Cadastrar Usuário', 'usuario/cadastroUsuario', true, true, true, false,  2);
INSERT INTO `mydb`.`restricao` (`id`, `nome`, `tela`, `consultar`, `cadastrar`, `alterar`, `excluir`, `grupo_id`) VALUES ('2', 'Vendas - Cadastrar Fornecedor', 'fornecedor/cadastroFornecedor', true, true, true, false, 2);


INSERT INTO `mydb`.`usuario` (`id`, `nome`, `email`, `senha`, `telefone`, `grupo_id`) VALUES ('999', 'Administrador', 'administrador@nexus.com', 'teste', '4199999999', '1');
INSERT INTO `mydb`.`usuario` (`id`, `nome`, `email`, `senha`, `telefone`, `grupo_id`) VALUES ('1', 'Vendedor', 'vendas@nexus.com', 'teste', '4199999999', '2');

INSERT INTO `mydb`.`fornecedor` (`id`, `nome`, `telefone`, `email`, `usuario_id`) VALUES ('1', 'Fornecedor Teste', '41999999999', 'fornecedorteste@gmail.com', '1');

INSERT INTO `mydb`.`produto` (`id`, `descricao`, `quantidade`, `codigo_de_barras`, `preco_compra`, `valor_venda`, `fornecedor_id`) VALUES ('1', 'Protuto Teste', '10', '123456789', '1.00', '1.50', '1');
INSERT INTO `mydb`.`produto` (`id`, `descricao`, `quantidade`, `codigo_de_barras`, `preco_compra`, `valor_venda`, `fornecedor_id`) VALUES ('2', 'Protuto 2', '50', '1234567890', '2.30', '4.50', '1');










