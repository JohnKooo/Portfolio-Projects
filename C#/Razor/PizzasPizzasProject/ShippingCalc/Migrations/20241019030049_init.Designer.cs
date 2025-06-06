﻿// <auto-generated />
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using ShippingCalc.Data;

#nullable disable

namespace ShippingCalc.Migrations
{
    [DbContext(typeof(AppDbContext))]
    [Migration("20241019030049_init")]
    partial class init
    {
        /// <inheritdoc />
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder.HasAnnotation("ProductVersion", "8.0.10");

            modelBuilder.Entity("ShippingCalc.Models.ObjectItem", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("INTEGER");

                    b.Property<float>("BaseCost")
                        .HasColumnType("REAL");

                    b.Property<float>("CrustCost")
                        .HasColumnType("REAL");

                    b.Property<int>("CrustType")
                        .HasColumnType("INTEGER");

                    b.Property<float>("NumberOfPizzas")
                        .HasColumnType("REAL");

                    b.Property<string>("NumberOfToppings")
                        .IsRequired()
                        .HasColumnType("TEXT");

                    b.Property<int>("PizzaSize")
                        .HasColumnType("INTEGER");

                    b.Property<float>("SubTotal")
                        .HasColumnType("REAL");

                    b.Property<float>("ToppingCost")
                        .HasColumnType("REAL");

                    b.Property<float>("TotalCost")
                        .HasColumnType("REAL");

                    b.HasKey("Id");

                    b.ToTable("Objects");
                });
#pragma warning restore 612, 618
        }
    }
}
