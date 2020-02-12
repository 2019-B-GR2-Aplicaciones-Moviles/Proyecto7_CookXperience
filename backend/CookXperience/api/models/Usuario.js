/**
 * Usuario.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    nombreUsuario: {
      type: 'string',
      required:true
    },

    mail: {
      type: 'string',
      required:true
    },

    usernameUsuario: {
      type: 'string',
      required:true
    },
    clave: {
      type: 'string',
      required:true
    },
    recetaDeUsuario: {     // Nombre atributo de la relación
      collection: 'receta', // Nombre del modelo a relacionar
      via: 'usuarioId'        // Nombre del campo a hacer la relacion
    },


  },

};

